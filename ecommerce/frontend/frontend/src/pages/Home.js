// src/pages/Home.js
import React, { useState } from 'react';
import ProductList from '../components/ProductList';
import Cart from '../components/Cart';

const Home = () => {
    const [cart, setCart] = useState([]);

    const addToCart = (product) => {
        setCart([...cart, product]);
    };

    const clearCart = () => {
        setCart([]);
    };

    return (
        <div className="home">
            <ProductList addToCart={addToCart} />
            <Cart cartItems={cart} clearCart={clearCart} />
        </div>
    );
};

export default Home;
