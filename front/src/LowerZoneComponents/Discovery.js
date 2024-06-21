import React, {useContext} from 'react';
import "../componentsStyles/LowerZone.css";

import { useSelector} from 'react-redux';

import dictEnglish from "../constants/Translations";


function Discovery() {

    const dict = dictEnglish;

    return (
        <div className="content-container">
            <p> {dict.discoveryTextD} </p>
        </div>
    );
}

export default Discovery;

