import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ProductList({ addToCart }) {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/products')
            .then(response => setProducts(response.data))
            .catch(error => console.error('Error fetching products:', error));
    }, []);

    return (
        <div className="container mx-auto p-6">
            <h2 className="text-3xl font-bold text-center mb-8">Products</h2>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                {products.map(product => (
                    <div key={product.id} className="bg-white rounded-lg shadow-lg overflow-hidden transform transition duration-500 hover:scale-105">
                        <img src={`http://localhost:8080/api/images/${product.imageId}`} alt={product.name} className="w-full h-48 object-cover" />
                        <div className="p-4">
                            <h3 className="text-xl font-semibold mb-2">{product.name}</h3>
                            <p className="text-gray-600">{product.description}</p>
                            <p className="text-lg font-bold mt-4">${product.price}</p>
                            <button
                                onClick={() => addToCart(product)}
                                className="mt-4 bg-blue-600 text-white py-2 px-4 rounded hover:bg-blue-700"
                            >
                                Add to Cart
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default ProductList;