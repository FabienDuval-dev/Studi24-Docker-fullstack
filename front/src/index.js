import React from 'react';
import { createRoot } from 'react-dom/client';
import App from './App';
import {Provider} from 'react-redux' ;
import store from './redux/store';

// Trouve l'élément racine du DOM
const rootElement = document.getElementById('root');
const root = createRoot(rootElement); // Crée une racine

// Rendu de l'application avec le LanguageProvider et App
root.render(
    <Provider store={store}>
        <App />
    </Provider>
);
