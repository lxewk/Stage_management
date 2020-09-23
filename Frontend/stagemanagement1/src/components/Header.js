import React from "react";

import { HeaderContainer,
         HeaderLogo,
         LogoSpan,
         LogoItalic } from "./styled/container/HeaderContainer";
         
import { HeaderButton } from './styled/button/HeaderButton';

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