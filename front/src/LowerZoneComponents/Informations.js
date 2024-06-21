import "../componentsStyles/LowerZone.css";

import dictEnglish, {useActualDict} from '../constants/Translations';

import { useSelector } from 'react-redux';
import Translations from "../constants/Translations";

import {useContext} from "react";

function Informations() {

    const dict = dictEnglish;

    return (
        <div className="content-container">
            <p>{dict.informationTextD}</p>
        </div>
    );
}

export default Informations;
