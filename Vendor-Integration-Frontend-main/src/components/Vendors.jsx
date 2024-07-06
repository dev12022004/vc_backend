import axios from 'axios';
import React, { useState } from 'react';

const Vendors = () => {
  const [name, setName] = useState('');
  const [type, setType] = useState('');
  const [contractPeriod, setContractPeriod] = useState('');
  const [contractEnding, setContractEnding] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = {
      name: name,
      type: type,
      contractPeriod: contractPeriod,
      contractEnding: formatDate(contractEnding), // Format date before sending
      _class: 'com.example.demo.model.Vendor',
    };

    try {
      const response = await axios.post('http://localhost:9087/api/vendors', formData);
      setMessage('Vendor added successfully');
    } catch (error) {
      setMessage(`Error adding vendor: ${error.response ? error.response.data.message : error.message}`);
    }
  };

  // Function to format date as yyyy-mm-dd
  const formatDate = (dateString) => {
    const date = new Date(dateString);
    const year = date.getFullYear();
    let month = (1 + date.getMonth()).toString().padStart(2, '0');
    let day = date.getDate().toString().padStart(2, '0');

    return `${year}-${month}-${day}`;
  };

  return (
    <div>
      <h2>Add Vendor</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
        </div>
        <div>
          <label>Type:</label>
          <input type="text" value={type} onChange={(e) => setType(e.target.value)} required />
        </div>
        <div>
          <label>Contract Period:</label>
          <input type="text" value={contractPeriod} onChange={(e) => setContractPeriod(e.target.value)} required />
        </div>
        <div>
          <label>Contract Ending:</label>
          <input type="date" value={contractEnding} onChange={(e) => setContractEnding(e.target.value)} required />
        </div>
        <button type="submit">Add Vendor</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default Vendors;
