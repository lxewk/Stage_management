import React, { useState, useContext, useEffect } from 'react'
import { NavLinkContext } from '../../contexts/NavLinkContext'

import { HeaderButton } from '../../components/styled/button/HeaderLogoutButton'

import { NavMenu,
         ListItem,	
         MenuIcon,
         NavLinks,
         Icons,
         Bars,
         HeaderContainer,
         HeaderLogo,
         LogoSpan,
         LogoItalic,
} from './HeaderCss'


export const Header = () => {
  const { navLinks } = useContext(NavLinkContext)
  
  const [clicked, setClicked] = useState(false)
  const [hoverIndex, setHoverIndex] = useState(-1)

  useEffect(() => {
    console.log('useEffect Header ran', navLinks)
  }, [navLinks])
  
  return (
    <HeaderContainer>
      <HeaderLogo >
        <LogoItalic>STAGE</LogoItalic> <LogoSpan><i>M</i>anagement</LogoSpan> 
      </HeaderLogo>

      <NavMenu 
        className={clicked ? 'active' : '' }
        >   
        {navLinks.map((item, index) => {
          return (
            <ListItem
              key={item.title}
              onMouseEnter={ () => setHoverIndex(index) }
              onMouseLeave={ () => setHoverIndex(-1) }
              style={{ background: hoverIndex === index ? '#6d76f7' : '' }}
            >
              <NavLinks
                to={item.path}
              >
                { item.title }
                <Icons className={item.icon} />
              </NavLinks>
            </ListItem>
          )
        })}
        <HeaderButton />
        <MenuIcon onClick={ () => setClicked(!clicked) }>
          <Bars className='fas fa-bars'/>
        </MenuIcon>
      </NavMenu>
    </HeaderContainer>
  );
};

export default Header;