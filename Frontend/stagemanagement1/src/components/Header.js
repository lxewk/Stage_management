import React from "react";

import { HeaderContainer, HeaderLogo, LogoSpan, LogoItalic } from "../styles/elements";
import { HeaderButton } from './button/HeaderButton';

export const Header = () => {
  
  return (
    <HeaderContainer>
      <HeaderLogo >
        <LogoItalic>STAGE</LogoItalic> <LogoSpan><i>M</i>anagement</LogoSpan> 
      </HeaderLogo>
      <HeaderButton />
    </HeaderContainer>
  );
};

export default Header;