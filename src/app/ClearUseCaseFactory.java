package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearPresenter;
import interface_adapter.clear_users.ClearViewModel;

import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInteractor;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearUserDataAccessInterface;


import java.io.IOException;

public class ClearUseCaseFactory {
    private ClearUseCaseFactory() {}

    public static ClearController createClearUseCase(ViewManagerModel viewManagerModel, ClearViewModel clearViewModel, ClearUserDataAccessInterface userDataAccessObject) throws IOException {
        // Notice how we pass this method's parameters to the Presenter.
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(viewManagerModel, clearViewModel);

        UserFactory userFactory = new CommonUserFactory();

        ClearInputBoundary clearInteractor = new ClearInteractor(
                userDataAccessObject, clearOutputBoundary);

        return new ClearController(clearInteractor);
    }
}
