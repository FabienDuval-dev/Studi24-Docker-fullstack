import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

// Importe les composants de chaque page
import discovery from './routes/discovery';
import tickets from './routes/tickets';
import home from './routes/home';
import qrcode from './routes/qrcode';
import informations from './routes/informations';

function RouteFile() {
    return (
        <Router>
            <Routes>
                <Route path="/" exact component={home} />
                <Route path="/discovery" component={discovery} />
                <Route path="/tickets" component={tickets} />
                <Route path="/qrcode" component={qrcode} />
                <Route path="/informations" component={informations} />
            </Routes>
        </Router>
    );
}

export default RouteFile;
