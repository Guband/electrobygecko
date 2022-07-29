import React, {useEffect, useState} from 'react';
import {useParams, withRouter} from "react-router-dom";
import { getProduit} from "../services/produitsService";

function Produit() {

    const [produit, setProduit] = useState({})
    const { id } = useParams();

    useEffect(() => {
        getProduit(id)
            .then(items => {
                setProduit(items)
            })
    }, [])

    return (
        <div className="container my-5">
            <div className="">
                <div className="row text-center">
                    <div className="col-7 p-0"><img className="img-fluid" src={produit.image} alt="" />
                    </div>
                    <div className="col p-0">
                        <div className="h1 p-3 fw-bold bg-dark text-white">{produit.name} <span
                            className="h3">par {produit.brand}</span></div>
                        <div className="h5 p-4 text-justify">
                            {produit.description}
                        </div>
                        <div className="h3 p-3 mt-5 badge bg-secondary"><h1>{produit.price} €</h1></div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Produit