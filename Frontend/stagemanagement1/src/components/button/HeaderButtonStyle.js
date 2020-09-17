import styled, { css } from "styled-components";
import { colors } from "../../styles/global.js";

export const HeaderBut = styled.button`
    
    background-color: transparent;
    border: none;
    align-self: center;
    cursor: pointer;
    padding-right: 40px;
    font-size: 100%;
    color: ${colors.headerLogoWhite};

    ${props => props.outline && css`
    outline: none !important;
    `}
`;