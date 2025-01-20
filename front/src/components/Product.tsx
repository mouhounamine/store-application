// src/components/Product.tsx

import React from "react";

// Définir un type pour un produit
type ProductType = {
  id: string;
  name: string;
  price: number;
};

const Product = ({ product }: { product: ProductType }) => {
  return (
    <div className="bg-white shadow-lg rounded-lg p-4 hover:shadow-xl transition-shadow duration-200">
      <h2 className="text-2xl font-semibold mb-2 text-center">
        {product.name}
      </h2>
      <p className="text-xl text-gray-600 text-center mb-4">${product.price}</p>
      <div className="flex justify-center">
        <button className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition duration-300">
          Add to Cart
        </button>
      </div>
    </div>
  );
};

export default Product;
