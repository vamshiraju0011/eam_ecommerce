import React from 'react';

const Cart = ({ cartItems, clearCart, removeFromCart }) => {
    const total = cartItems.reduce((sum, item) => sum + item.price, 0);

    const handleCheckout = () => {
        alert('Checkout successful!');
        clearCart();
    };


    return (
        <div className="cart container mx-auto p-6 bg-white rounded-lg shadow-lg">
            <h2 className="text-3xl font-bold text-center mb-4">Shopping Cart</h2>
            {cartItems.length === 0 ? (
                <p className="text-gray-600 text-center">Your cart is empty</p>
            ) : (
                <div>
                    {cartItems.map((item, index) => (
                        <div key={index} className="cart-item flex justify-between items-center p-4 bg-gray-100 rounded-lg mb-4">
                            <div>
                                <p className="text-lg font-semibold">{item.name}</p>
                                <p className="text-gray-600">${item.price}</p>
                            </div>
                            <button
                                onClick={() => removeFromCart(index)}
                                className="bg-red-600 text-white py-2 px-4 rounded hover:bg-red-700"
                            >
                                Remove
                            </button>
                        </div>
                    ))}
                    <h3 className="text-2xl font-bold text-right mt-4">Total: ${total}</h3>
                    <div className="text-right mt-4">
                        <button
                            onClick={handleCheckout}
                            className="bg-blue-600 text-white py-2 px-6 rounded hover:bg-blue-700"
                        >
                            Checkout
                        </button>
                    </div>
                </div>
            )}
        </div>
    );
};

export default Cart;
