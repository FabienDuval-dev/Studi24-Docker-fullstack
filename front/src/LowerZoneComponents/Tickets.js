import "../componentsStyles/LowerZone.css";
import '../componentsStyles/TicketsStyle.css';
import { useSelector } from 'react-redux';
import { useState } from "react";
import apiService from '../Controller/apiService.js';

function Tickets() {
    const isLogged = useSelector(state => state.isLogged);

    const [ticketNumber, setTicketNumber] = useState(1);

    // Submit the ticket to the backend
    const handleTicketSubmit = async () => {
        try {
            if (ticketNumber !== 0 && isLogged) {
                const response = await apiService.postTicket({ ticketNumber });
                console.log('Tickets submitted:', response.data);
            } else {
                console.error('Error: User is not logged in or no ticket selected');
            }
        } catch (err) {
            console.error('Error submitting tickets:', err);
        }
    };

    // Change the ticket number
    const handleTicketChange = (event) => {
        setTicketNumber(parseInt(event.target.value));
    };

    return (
        <div>
            <p> Choix du billet </p>
            <div>
                <h2>Choose Tickets</h2>
                <div>
                    <input
                        type="radio"
                        value="1"
                        checked={ticketNumber === 1}
                        onChange={handleTicketChange}
                    /> 1 Ticket (20 euros)
                </div>
                <div>
                    <input
                        type="radio"
                        value="2"
                        checked={ticketNumber === 2}
                        onChange={handleTicketChange}
                    /> 2 Tickets (30 euros)
                </div>
                <div>
                    <input
                        type="radio"
                        value="4"
                        checked={ticketNumber === 4}
                        onChange={handleTicketChange}
                    /> 4 Tickets (40 euros)
                </div>
                <button onClick={handleTicketSubmit}>Submit Tickets</button>
            </div>
        </div>
    );
}

export default Tickets;