import "../componentsStyles/LowerZone.css";
import "../componentsStyles/QrCodeStyle.css";
import imageQR from '../images/imageQrCodeExample.png';

import { useSelector } from 'react-redux';

function QrCode() {

    const name = useSelector(state => state.name);
    const surname = useSelector(state => state.surname);
    const email = useSelector(state => state.email);
    const isLogged = useSelector(state => state.login); // Correction : renommer en isLogged pour plus de clarté

    let qrCode = null; // this is a mockup, the real qrCode will be fetched from the backend

    // Function to handle QR Code fetching
    const handleGetQrCode = async () => {
        try {
            if (qrCode === null || !isLogged) {
                alert('You must be logged in to get a QR Code. You also need to have bought a ticket.');
            } else {
                console.log('Here is your qrCode');
                // Logic to fetch and display QR code from backend
            }
        } catch (error) {
            console.error('Error fetching QR Code:', error);
        }
    };

    // Function to display the ticket
    const displayTicket = () => {
        alert('Displaying ticket');
    };

    // Function to print the ticket
    const printTicket = () => {
        alert('Printing ticket');
    };

    return (
        <div className='form-container'>
            <img src={imageQR} alt="QR Code" className="qrcode-container" />
            <div className='button-container'>
                <button type='button' // Correction : type should be 'button' to prevent form submission behavior
                        className='button-itself'
                        onClick={displayTicket}>Display QR Code</button>

                <button type='button' // Correction : type should be 'button' to prevent form submission behavior
                        className='button-itself'
                        onClick={printTicket}>Print Ticket</button>
            </div>
        </div>
    );
}

export default QrCode;