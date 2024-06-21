import {createSlice} from '@reduxjs/toolkit';

const initialState = {
    surname:''
};

const surnameSlice = createSlice({
    name: 'surname',
    initialState,
    reducers: {
        surnameReducer(state, action) {
            state.surname = action.payload;
        }
    },
});

export const {surnameReducer} = surnameSlice.actions;

export default surnameSlice.reducer;
