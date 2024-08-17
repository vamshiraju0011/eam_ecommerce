import React from 'react';

const Layout = ({ children }) => {
    return (
        <div className="min-h-screen flex flex-col">
            <header className="bg-blue-600 text-white py-4">
                <div className="container mx-auto">
                    <h1 className="text-3xl font-bold">E-Commerce Store</h1>
                </div>
            </header>
            <main className="flex-grow container mx-auto py-8">
                {children}
            </main>
            <footer className="bg-gray-800 text-white py-4">
                <div className="container mx-auto text-center">
                    <p>© 2024 E-Commerce Store. All rights reserved.</p>
                </div>
            </footer>
        </div>
    );
};

export default Layout;