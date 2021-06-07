import React from 'react';
import {Navbar, NavbarBrand} from 'reactstrap';
import "./Header.css";

const Header = () => {

    return (
        <div>
            <Navbar light expand="md">
                <NavbarBrand id="header"> Welcome to the Software Engineering Final Assessment Project! </NavbarBrand>
            </Navbar>
        </div>
    )

};

export default Header;