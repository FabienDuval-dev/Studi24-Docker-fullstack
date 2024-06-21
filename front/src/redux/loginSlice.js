import {createSlice} from '@reduxjs/toolkit';

const initialState = {
    isLogged: false,
};

export const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        userReducer(state) {
            state.isLogged = !state.isLogged;
        },
    },
});

export const {userReducer} = userSlice.actions;

export default userSlice.reducer;