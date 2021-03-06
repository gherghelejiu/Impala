package hainguyen.impala.feature.userdetails.presenter;

import javax.inject.Inject;

import hainguyen.impala.application.ApplicationBus;
import hainguyen.impala.feature.userdetails.view.UserDetailsView;

public class UserDetailsPresenterImpl implements UserDetailsPresenter {

    UserDetailsView detailsView;
    ApplicationBus bus;

    @Inject
    public UserDetailsPresenterImpl(ApplicationBus applicationBus) {
        bus = applicationBus;
    }

    @Override
    public void setView(UserDetailsView view) {
        detailsView = view;
    }

    @Override
    public void destroyView() {
        detailsView = null;
    }

    @Override
    public void getUserDetails() {
        if (bus.getLoginResponse() != null) {
            detailsView.populateUserDetails(bus.getLoginResponse());
        } else {
            detailsView.backToLoginScreen();
        }
    }
}
