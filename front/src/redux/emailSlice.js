import {createSlice} from '@reduxjs/toolkit';

const initialState = {
    email:''
};

const emailSlice = createSlice({
    name: 'email',
    initialState,
    reducers: {
        emailReducer(state, action) {
            state.email = action.payload;
        }
    },
});

export const {emailReducer} = emailSlice.actions;

export default emailSlice.reducer;