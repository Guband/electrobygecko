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
        <div>
            <a className="btn btn-primary m-2" href={"/"}>Retour</a>
            <div className="container my-5">

                <div className="">
                    <div className="row text-center">
                        <div className="col-7 p-0"><img className="img-fluid" src={"http://localhost:3000/"+produit.image} alt="" />
                        </div>
                        <div className="col p-0">
                            <div className="h1 p-3 fw-bold bg-dark text-white">{produit.name} <span
                                className="h3">par {produit.brand}</span></div>
                            <div className="h5 m-0 bg-white p-4 text-justify">
                                {produit.description}
                            </div>
                            <div className="h3 p-3 mt-5 badge bg-success"><h1>{produit.price/100} €</h1></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Produit