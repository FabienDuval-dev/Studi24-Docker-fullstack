import "../componentsStyles/LowerZone.css";
// import bcrypt from 'bcryptjs'; // this is a mockup, the real bcrypt will be fetched from the backend
import '../componentsStyles/HomeStyle.css';

import { useDispatch } from 'react-redux';
import { userReducer } from '../redux/loginSlice.js';

import React, { useState } from 'react';
import apiService from '../Controller/apiService.js';
import { useSelector } from 'react-redux';
import dictEnglish from "../constants/Translations.js";

function Home() {
    const dispatch = useDispatch();
    const dict = dictEnglish;

    const [client, setClient] = useState(null);
    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [email, setEmail] = useState('');
    let [password, setPassword] = useState('');
    const [isLogged, setIsLogged] = useState(false);

    // If the client wants to log in, ask the backend if the client belongs to the database
    const handleLogin = async () => {
        try {
            const clientInfo = { email, password };
            const response = await apiService.checkClient(clientInfo);
            setIsLogged(true);
            setClient(response.data);
        } catch (error) {
            console.error('Error logging in:', error);
        }
    };

    // Creation of a new client in the database
    const handleCreateClient = async () => {
        try {
            let isAName = name !== '';
            let isASurname = surname !== '';
            let isAnEmail = email !== '';
            let isAPassword = password !== '';

            let isAllFieldsAreFilled = isAName && isASurname && isAnEmail && isAPassword;

            if (!isAllFieldsAreFilled) {
                alert('Please fill in all fields.');
                return;
            } else {
                //  const hashedPassword = bcrypt.hashSync(password, 10);
                // this line is replaced by a mockup Password
                const hashedPassword = 'mockupPassword';
                password = '';
                const client = { name, surname, email, hashedPassword };
                const response = await apiService.createClient(client);
                setClient(response.data);
                dispatch(userReducer());
            }
        } catch (error) {
            console.error('Error creating client:', error);
        }
    };

    const handleDeleteClient = async () => {
        try {
            if (!client || !client.id) {
                alert('Client not logged in.');
                return;
            }
            await apiService.deleteClient(client.id);
            setClient(null);
            dispatch(userReducer());
        } catch (error) {
            alert('Error deleting client:', error);
        }
    };

    return (
        <span className="home-container">
            <div>
                <form className="form-container vertical">
                    <label>
                        Name: <input type="text"
                                     value={name}
                                     onChange={e => setName(e.target.value)} />
                    </label>
                    <label>
                        Surname: <input type="text"
                                        value={surname}
                                        onChange={e => setSurname(e.target.value)} />
                    </label>
                    <label>
                        Email: <input type="email"
                                      value={email}
                                      onChange={e => setEmail(e.target.value)} />
                    </label>
                    <label>
                        Password: <input type="password"
                                         value={password}
                                         onChange={e => setPassword(e.target.value)} />
                    </label>
                </form>
            </div>

            <span className="form-container horizontal">
                <button type="button"
                        className='button-submit'
                        onClick={handleCreateClient}> Sign up
                </button>
                <button type="button"
                        className='button-submit'
                        onClick={handleLogin}> Log in
                </button>
                <button type="button"
                        className="button-delete"
                        onClick={handleDeleteClient}> Delete account
                </button>
            </span>
        </span>
    );
}

export default Home;