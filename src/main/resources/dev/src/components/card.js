import React from 'react';

function Card(props){
    return (
        <div className="col-md-4 col-sm-6 col-xs-12 p-2 border border-3 bg-white">
            <div className="row">
                <div className="col-1"></div>
                <div className="col">
                    <div>
                        <img className="img-fluid" src={props.image} alt="" />
                    </div>
                    <div className="fw-bold h3">{props.nom}</div>
                    <div>{props.description}</div>
                    <div className="fw-bold">{props.prix/100} €</div>
                    <a className="lienprops" id={props.id} href={"/produit/"+ props.idProduit}><div className="btn btn-purple">Voir les details</div></a>
                </div>
                <div className="col-1"></div>
            </div>
        </div>
    )
}

export default Card
