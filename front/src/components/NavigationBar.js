import { useNavigate } from 'react-router-dom';
import Translations from "../constants/Translations";

import routes from '../routes/routes';

import {useSelector} from "react-redux";

import '../componentsStyles/NavigationBar.css';
import dictEnglish from "../constants/Translations";

const components = [ 'Discovery', 'Tickets', 'Home', 'QrCode', 'Informations'];

const ROUTES = ['discovery', 'tickets', 'home', 'qrcode', 'informations'];

const dict = dictEnglish;

const images = [dict.discoveryImage,
                            dict.ticketsImage,
                            dict.homeImage,
                            dict.qrCodeImage,
                            dict.informationsImage];


function NavigationBar(props) {
    const dict = dictEnglish;
    const navigate = useNavigate(); // Add this line
    return (
        <>
            <div className="navigation-bar">

                <button  onClick={() => navigate(ROUTES[0])}>
                    <ul>
                        <li>
                            <img src={images[0]} alt="Discovery"/>
                        </li>
                        <li>
                            {dict.discoveryD}
                        </li>
                    </ul>
                </button>

                <button onClick={() => navigate(ROUTES[1])}>
                    <ul>
                        <li>
                            <img src={images[1]} alt="Tickets"/>
                        </li>
                        <li>
                           {dict.ticketsD}
                        </li>
                    </ul>
                </button>

                <button onClick={() => navigate(ROUTES[2])}>
                    <ul>
                        <li>
                            <img src={images[2]} alt="Home"/>
                        </li>
                        <li>
                            {dict.homeD}
                        </li>
                    </ul>
                </button>

                <button onClick={() => navigate(ROUTES[3])}>
                    <ul>
                        <li>
                            <img src={images[3]} alt="Qrcode"/>
                        </li>
                        <li>
                            {dict.qrCodeD}
                        </li>
                    </ul>
                </button>

                <button onClick={() => navigate(ROUTES[4])}>
                    <ul >
                        <li>
                            <img src={images[4]} alt="Informations"/>
                        </li>
                        <li>
                            {dict.informationsD}
                        </li>
                    </ul>
                </button>

            </div>
        </>
    );
}


export default NavigationBar;