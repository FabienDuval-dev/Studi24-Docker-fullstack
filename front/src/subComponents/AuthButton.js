// AuthButton.js
import React, {useState, useEffect} from 'react';
import { useDispatch, useSelector } from 'react-redux';
import {userReducer} from '../redux/loginSlice';

function AuthButton() {
    const dispatch = useDispatch();
    const isLogged = useSelector(state => state.user.isLogged);
    const [buttonColor, setButtonColor] = useState('red');
    const [buttonText, setButtonText] = useState('Disconnected');
    console.log('isLogged after useSelector:', isLogged);

    useEffect(() => {
        if (isLogged === false || isLogged === undefined) {
            setButtonColor('green');
            setButtonText('Connected');
        } else {
            setButtonColor('red');
            setButtonText('Disconnected');
        }
    }, [isLogged]);

    function changeLogged() {
        dispatch(userReducer());
        console.log('isLogged after dispatch',isLogged);
    }

    return(
        <button
            style={{
                backgroundColor: buttonColor,
                color: 'white',
                border: 'none',
                padding: '10px 20px',
                cursor: 'pointer'
            }}

            onClick={changeLogged}
        >
            {buttonText}
        </button>
    );
}

export default AuthButton;