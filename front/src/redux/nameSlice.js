import {createSlice} from '@reduxjs/toolkit';


const initialState = {
    name:''
};

const nameSlice = createSlice({
    name: 'name',
    initialState,
    reducers: {
        nameReducer(state, action) {
            state.name = action.payload;
        }
    },
});

export const {nameReducer} = nameSlice.actions;

export default nameSlice.reducer;