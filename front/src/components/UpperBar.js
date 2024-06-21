import image from '../images/imageLaurel.svg';
import '../componentsStyles/UpperBar.css';
import React, { useContext } from 'react';
import { useSelector } from 'react-redux';
import dictEnglish from "../constants/Translations.js";


function UpperBar() {

    let dict = dictEnglish;
    const message = dict.mainTitleD;
    const dictLanguage = useSelector(state => state.language);
    return (
        <div className="upper-bar">
            <ul>
                <li>
                    <img src={image} alt="Laurel"/>
                </li>
                <li>
                    <h1>{message}</h1>
                </li>
                <li>
                    <img src={image} alt="Laurel"/>
                </li>
            </ul>
        </div>
    );
}

export default UpperBar;
