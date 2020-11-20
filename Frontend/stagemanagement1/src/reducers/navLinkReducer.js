export const navLinkReducer = (state, action) => {
    
    switch (action.type) {
        case 'SET_NAV_BLANC':
            state = [
                {
                    title: '',
                    path: '',
                    icon: '',
                }    
            ]
            return state;
        case 'SET_NAV_STAGEMANAGER':
            state = [
                {
                    title: 'Dashboard',
                    path: '/dashboard',
                    icon: 'ion-home'
                },
                {
                    title: 'Playlist',
                    path: '/playlist',
                    icon: 'ion-calendar'
                },
                {
                    title: 'Add',
                    path: '/addItem',
                    icon: 'ion-plus'
                },
                {
                    title: 'Decor',
                    path: '/decor',
                    icon: 'ion-hammer'
                },
                {
                    title: 'Props',
                    path: '/prop',
                    icon: 'ion-android-color-palette'
                },
                {
                    title: 'Automation',
                    path: '/automation',
                    icon: 'ion-ios-gear'
                },
                {
                    title: 'Track',
                    path: '/track',
                    icon: 'ion-clipboard'
                },
                {
                    title: 'Account',
                    path: '/account',
                    icon: 'ion-person-add'
                },
            ]
           return state;
        case 'SET_NAV_DEPUTY':
            state = [
                {
                    title: 'Dashboard',
                    path: '/dashboard',
                    icon: 'ion-home'
                },
                {
                    title: 'Add',
                    path: '/addItem',
                    icon: 'ion-plus'
                },
                {
                    title: 'Decor',
                    path: '/decor',
                    icon: 'ion-hammer'
                },
                {
                    title: 'Props',
                    path: '/prop',
                    icon: 'ion-android-color-palette'
                },
                {
                    title: 'Automation',
                    path: '/automation',
                    icon: 'ion-ios-gear'
                },
                {
                    title: 'Account',
                    path: '/account',
                    icon: 'ion-person-add'
                },
            ]
            return state;
        case 'SET_NAV_ASSISTANT':
            state = [
                {
                    title: 'Dashboard',
                    path: '/dashboard',
                    icon: 'ion-home'
                },
                {
                    title: 'Decor',
                    path: '/decor',
                    icon: 'ion-hammer'
                },
                {
                    title: 'Props',
                    path: '/prop',
                    icon: 'ion-android-color-palette'
                },
                {
                    title: 'Automation',
                    path: '/automation',
                    icon: 'ion-ios-gear'
                },
                {
                    title: 'Track',
                    path: '/track',
                    icon: 'ion-clipboard'
                },
            ]
            return state;
        case 'SET_NAV_CREW':
            state = [
                {
                    title: 'Dashboard',
                    path: '/dashboard',
                    icon: 'ion-home'
                },
                {
                    title: 'Decor',
                    path: '/decor',
                    icon: 'ion-hammer'
                },
                {
                    title: 'Props',
                    path: '/prop',
                    icon: 'ion-android-color-palette'
                },
                {
                    title: 'Automation',
                    path: '/automation',
                    icon: 'ion-ios-gear'
                },
                {
                    title: 'Track',
                    path: '/track',
                    icon: 'ion-clipboard'
                },
            ]
            return state; 
        case 'SET_NAV_PROPS':
            state = [
                {
                    title: 'Dashboard',
                    path: '/dashboard',
                    icon: 'ion-home'
                },
                {
                    title: 'Add',
                    path: '/addItem',
                    icon: 'ion-plus'
                },
                {
                    title: 'Decor',
                    path: '/decor',
                    icon: 'ion-hammer'
                },
                {
                    title: 'Props',
                    path: '/prop',
                    icon: 'ion-android-color-palette'
                },
                {
                    title: 'Automation',
                    path: '/automation',
                    icon: 'ion-ios-gear'
                },
            ]
            return state; 
        case 'SET_NAV_CREATIVE':
            state = [
                {
                    title: 'Dashboard',
                    path: '/dashboard',
                    icon: 'ion-home'
                },
                {
                    title: 'Decor',
                    path: '/decor',
                    icon: 'ion-hammer'
                },
                {
                    title: 'Props',
                    path: '/prop',
                    icon: 'ion-android-color-palette'
                },
                {
                    title: 'Automation',
                    path: '/automation',
                    icon: 'ion-ios-gear'
                },
            ]
            return state;
        case 'SET_NAV_PRODUCTION':
            state = [
                {
                    title: 'Dashboard',
                    path: '/dashboard',
                    icon: 'ion-home'
                },
                {
                    title: 'Decor',
                    path: '/decor',
                    icon: 'ion-hammer'
                },
                {
                    title: 'Props',
                    path: '/prop',
                    icon: 'ion-android-color-palette'
                },
                {
                    title: 'Automation',
                    path: '/automation',
                    icon: 'ion-ios-gear'
                },
            ]
            return state;
        default:
            return state;
        
    }
}