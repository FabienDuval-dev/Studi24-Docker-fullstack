import React, { useContext } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate, useLocation } from 'react-router-dom';
import UpperBar from './components/UpperBar';
import LoginBar from "./components/LoginBar";
import NavigationBar from "./components/NavigationBar";
import Zone from "./components/ZoneBar";

import home from './routes/home';
import discovery from './routes/discovery';
import tickets from './routes/tickets';
import informations from './routes/informations';
import qrcode from './routes/qrcode';

import Discovery from "./LowerZoneComponents/Discovery";
import Tickets from "./LowerZoneComponents/Tickets";
import Informations from "./LowerZoneComponents/Informations";
import QrCode from "./LowerZoneComponents/QrCode";
import Home from "./LowerZoneComponents/Home";


import { Provider } from 'react-redux';
import store from './redux/store';


import { useSelector}  from "react-redux";

import dictEnglish from "./constants/Translations";

function Content() {

    let dict = dictEnglish;
    const location = useLocation();
    const type = location.pathname.slice(1); // remove the leading slash

    return (
        <Provider store={store}>
                <div>
                    <UpperBar />
                    <LoginBar />
                    <NavigationBar />
                    <Zone type={type} />
                    <Routes>
                        <Route path="/home" element={<home />} />
                        <Route path="/discovery" element={<discovery />} />
                        <Route path="/tickets" element={<tickets />} />
                        <Route path="/informations" element={<informations />} />
                        <Route path="/qrcode" element={<qrCode />} />

                        <Route path="/" element={<Navigate to="/home" replace />} />
                    </Routes>
                </div>
        </Provider>
    );
}

function App() {

    return (
        <Provider store={store}>
            <Router>
                <Content />
            </Router>
        </Provider>
    );
}

export default App;