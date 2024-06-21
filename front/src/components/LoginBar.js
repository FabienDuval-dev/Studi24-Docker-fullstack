import '../componentsStyles/LoginAndLanguage.css';


import AuthButton from '../subComponents/AuthButton';

function LoginBar() {
    return (
        <div className="login-and-language">
            <ul>
                <li className="auth-button">
                    <AuthButton/>
                </li>
            </ul>
        </div>
    );
}

export default LoginBar;