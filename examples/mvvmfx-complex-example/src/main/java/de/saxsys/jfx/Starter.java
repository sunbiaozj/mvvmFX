package de.saxsys.jfx;

import java.util.List;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;

import com.google.inject.Module;

import de.saxsys.jfx.exampleapplication.view.maincontainer.MainContainerView;
import de.saxsys.jfx.exampleapplication.viewmodel.maincontainer.MainContainerViewModel;
import de.saxsys.jfx.mvvm.di.guice.MvvmGuiceApplication;
import de.saxsys.jfx.mvvm.viewloader.ViewLoader;
import de.saxsys.jfx.mvvm.viewloader.ViewTuple;

/**
 * Entry point of the application.
 * 
 * @author sialcasa
 * 
 */
public class Starter extends MvvmGuiceApplication {

	// Get the MVVM View Loader
	@Inject
	private ViewLoader viewLoader;

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		final ViewTuple<MainContainerViewModel> tuple = viewLoader
				.loadViewTuple(MainContainerView.class);
		// Locate View for loaded FXML file
		final Parent view = tuple.getView();

		final Scene scene = new Scene(view);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initGuiceModules(List<Module> modules) throws Exception {

	}

}
