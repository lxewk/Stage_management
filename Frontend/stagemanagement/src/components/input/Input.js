import React from 'react';
import styled from 'styled-components';

const StyledInputElement = styled.input`
    // TODO
`;

const Input = ({ placeholder }) => {
    return(
        <StyledInputElement
            type="text"
            placeholder={placeholder}   
        />
    );
}

export default Input;