import React from 'react';
import styled from 'styled-components';

const StyledButtonElement = styled.button`
    // TODO
`;

const Button = ({ error }) => {
    return(
        <StyledButtonElement
            type="button"
        >
            Button
        </StyledButtonElement>
    );
}

export default Button;