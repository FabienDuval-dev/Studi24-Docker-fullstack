import {configureStore} from "@reduxjs/toolkit";
import userReducer from "./loginSlice";
import nameReducer from "./nameSlice";
import surnameReducer from "./surnameSlice";
import emailReducer from "./emailSlice";

const store = configureStore({
    reducer: {
        user: userReducer,
        userName: nameReducer,
        userSurname: surnameReducer,
        userEmail: emailReducer,
    },
});

export default store;
