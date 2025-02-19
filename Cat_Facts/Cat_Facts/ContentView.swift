import SwiftUI
import shared

struct ContentView: View {
    let viewModel = SharedViewModel()

	var body: some View {
        Observing(viewModel.uiState) { state in
            VStack {
                if let catFact = state.catFact {
                    Text(catFact)
                }
                Button("Fetch") {
                    viewModel.fetchCatFact()
                }
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
