import React from 'react'

const ProductList = ({products}) => {
  return (
    <div className="row">
      {products.map((product) => (
        <div
          key={product.id}
          className="col-lg-4 col-md-6 col-sm-12 mb-4 d-flex"
        >
          <div className="card h-100 shadow d-flex flex-column">
            <img
              src={product.imageUrl || "https://placehold.co/600x400"}
              alt={product.name}
              className="card-img-top"
            />
            <div className="card-body">
              <h5 className="card-title">{product.name}</h5>
              <p className="card-text">{product.description}</p>
              <h5 className="card-text">Ksh {product.price}/</h5>
              <p className="card-text">Category: {product.category.name}</p>
              <a href="#" className="btn btn-primary">
                Add to Cart
              </a>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}

export default ProductList