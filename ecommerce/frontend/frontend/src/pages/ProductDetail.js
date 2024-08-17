// src/pages/ProductDetail.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const ProductDetail = () => {
    const { id } = useParams();
    const [product, setProduct] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:8081/products/${id}`)
            .then(response => setProduct(response.data))
            .catch(error => console.error('Error fetching product', error));
    }, [id]);

    if (!product) return <p>Loading...</p>;

    return (
        <div className="product-detail">
            <h1>{product.name}</h1>
            <p>{product.description}</p>
            <p>${product.price}</p>
        </div>
    );
};

export default ProductDetail;