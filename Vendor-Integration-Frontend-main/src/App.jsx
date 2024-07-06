import React from 'react';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import './App.css';
import Footer from './components/Footer.jsx';
import Home from './components/Home.jsx';
import Navbar from './components/Navbar.jsx';
import TransactionDetails from './components/TransactionDetails.jsx';
import Transactions from './components/Transactions.jsx';
import Vendors from './components/Vendors.jsx';

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/vendors" element={<Vendors />} />
          <Route path="/transactions" element={<Transactions />} />
          <Route path="/transaction/:id" element={<TransactionDetails />} />
          <Route path="/analytics" element={<TransactionDetails />} />
        </Routes>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
