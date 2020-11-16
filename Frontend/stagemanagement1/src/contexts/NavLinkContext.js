import React, { createContext, useReducer } from 'react'
import { navLinkReducer } from '../reducers/navLinkReducer'

const NavLinkContext = createContext();

const initialState = [
    {
        title: '',
        path: '',
        icon: '',
    },
];

const NavLinkContextProvider = (props) => {
    const [navLinks, navDispatch] = useReducer(navLinkReducer, initialState);

    return (
        <NavLinkContext.Provider value={{navLinks, navDispatch}}>
            { props.children }
        </NavLinkContext.Provider>
    )
}

export {
        NavLinkContextProvider,
        NavLinkContext,
    } ;