import React from "react";

function Header(){
    return (

        <nav id="nav" className="navbar navbar-expand-lg sticky-top">
            <div className="container">
                <a className="navbar-brand" href="/">Electro By Gecko</a>
                <button className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">

                </div>
            </div>
        </nav>
    )
}

export default Header