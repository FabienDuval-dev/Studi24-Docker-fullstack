import React from 'react';
import '../componentsStyles/Zone.css';

import Home from '../LowerZoneComponents/Home';
import Discovery from '../LowerZoneComponents/Discovery';
import Tickets from '../LowerZoneComponents/Tickets';
import QrCode from '../LowerZoneComponents/QrCode';
import Informations from '../LowerZoneComponents/Informations';


function Zone({ type }) {
    let content;
    switch (type) {
        case 'home':
            content = <Home />;
            break;
        case 'discovery':
            content = <Discovery />;
            break;
        case 'tickets':
            content = <Tickets />;
            break;
        case 'qrcode':
            content = <QrCode />
            break;
        case 'informations':
            content = <Informations />;
            break;
        default:
            content = <Discovery />;
            break;
    }

    return (
        <div className="zone-frame">
            {content}
        </div>
    );
}

export default Zone;
