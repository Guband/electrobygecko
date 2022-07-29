export function getListProduits(search, priceMin, priceMax, brand, numberPage){
    return fetch(`/products?page=${numberPage}&search=${search}&minPrice=${priceMin}&maxPrice=${priceMax}&brand=${brand}`)
          .then(res => res.json())
}

export function getProduit(id){
    return fetch("/products/"+id)
        .then(res => res.json())
}
