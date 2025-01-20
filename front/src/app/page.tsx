"use client";

import Product from "@/components/Product";
import React, { useState, useEffect } from "react";

// Définir un type pour un produit
type ProductType = {
  id: string;
  name: string;
  price: number;
};

export default function Home() {
  // État pour stocker les produits
  const [products, setProducts] = useState<ProductType[]>([]);
  const [error, setError] = useState<string | null>(null);

  // Récupérer la liste des produits depuis le backend
  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await fetch("http://localhost:8083/api/products");
        if (!response.ok) {
          throw new Error("Failed to fetch products");
        }
        const data = await response.json();
        setProducts(data);
      } catch (error: any) {
        setError(error.message);
      }
    };

    fetchProducts();
  }, []); // La fonction s'exécute une fois au montage du composant

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-4xl font-semibold text-center mb-6">Product Store</h1>

      {/* Affichage de l'erreur si un problème survient */}
      {error && <div className="text-red-500 text-center">{error}</div>}

      {/* Affichage des produits */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
        {products.length === 0 ? (
          <p className="text-center col-span-full">Loading products...</p>
        ) : (
          products.map((product) => (
            <Product key={product.id} product={product} />
          ))
        )}
      </div>
    </div>
  );
}
