import React, {useEffect, useState} from 'react';
import Card from '../components/card';
import {getListProduits} from "../services/produitsService";

function Produits() {

    const [produits, setProduits] = useState([])
    const [totalElements, setTotalElements] = useState("")
    const [totalPages, setTotalPages] = useState(0)
    const [numberPage, setNumberPage] = useState("")
    const [search, setSearch] = useState("")
    const [brand, setBrand] = useState("")
    const [priceMin, setPriceMin] = useState("")
    const [priceMax, setPriceMax] = useState("")

    const handleSearch = (e) => {
        setSearch(e.target.value)
        setProduits([])
        setNumberPage(0)

    }
    const handleBrand = (e) => {
        setBrand(e.target.value)
        setProduits([])
        setNumberPage(0)

    }
    const handlePriceMin = (e) => {
        setPriceMin(e.target.value*100)
        setProduits([])
        setNumberPage(0)

    }
    const handlePriceMax = (e) => {
        setPriceMax(e.target.value*100)
        setProduits([])
        setNumberPage(0)

    }
    const handlePage = () => {
        setNumberPage(numberPage+1)
    }

    const setList = (search, priceMin, priceMax, brand, numberPage) => {
        getListProduits(search, priceMin, priceMax, brand, numberPage)
            .then(items => {
                if (items._embedded !== undefined){
                    if (items.page.number === 0){
                        setProduits(items._embedded.productDTOList)
                    } else {
                        setProduits([...produits, ...items._embedded.productDTOList])
                    }
                    setTotalElements(items.page.totalElements)
                    setNumberPage(items.page.number)
                    setTotalPages(items.page.totalPages)
                } else {
                    setProduits([])
                    setTotalElements(0)
                    setNumberPage("")
                    setTotalPages(0)
                }

            })
    }

    useEffect(() => {
        if (priceMax === 0) setPriceMax("")
        if (priceMin === 0) setPriceMin("")
        setList(search, priceMin, priceMax, brand, numberPage)
    }, [search, priceMax, priceMin, brand, numberPage])

    return (
        <div className="container my-5">
            <div id="filters" className="sticky-top mt-4 g-4 d-flex justify-content-around align-items-center">
                <div className="d-flex g-4">
                    <input onChange={handlePriceMin} placeholder="Prix Min" type="text" className="form-control mx-2"/>
                    <input onChange={handlePriceMax} placeholder="Prix Max" type="text" className="form-control"/>
                </div>
                <div>
                    <select onChange={handleBrand} className="form-select" aria-label="Default select example">
                        <option value="">Marques Tous</option>
                        <option value="Bosh">Bosh</option>
                        <option value="Whirlpool">Whirlpool</option>
                        <option value="Samsung">Samsung</option>
                        <option value="Liverpool">Liverpool</option>
                        <option value="Laden">Laden</option>
                        <option value="LG">LG</option>
                    </select>
                </div>
                <div>
                    <input onChange={handleSearch} className="form-control" type="search" placeholder="Rechercher un produit" />
                </div>
            </div>
            <div className="mt-5 row g-sm-2 g-md-2 gx-xs-1">
                {<div className="h5">{totalElements} produits trouv??s</div>}
                {produits !== "undefined" ? produits.map(p=>{
                    return <Card key={p.id}
                                      idProduit={p.id}
                                      nom={p.name}
                                      description={p.description}
                                      prix={p.price}
                                      image={p.image} />

                }) : <div className="h3 text-center">Aucun r??sultat</div>}
                {(( produits.length == 0) ||  ((parseInt(numberPage)+1) == parseInt(totalPages))) ? <div></div> : <div onClick={handlePage} className="m-4 btn btn-purple">Voir plus</div>}
            </div>
        </div>
    )
}

export default Produits