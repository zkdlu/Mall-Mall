import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';

export default function Root() {
    return (
        <App />   
    );
  }

ReactDOM.render(
    <React.StrictMode>
        <Root/>
    </React.StrictMode>
,document.getElementById('root'));
