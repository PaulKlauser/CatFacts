import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

	var body: some View {
        VStack {
            if let text = viewModel.text {
                Text(text)
            }
            Button("Fetch") {
                viewModel.fetchCatFact()
            }
        }
	}
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var text: String? = nil
        func fetchCatFact() {
            CatFactService().fetchCatFact { greeting, error in
                DispatchQueue.main.async {
                    if let greeting = greeting {
                        self.text = greeting
                    } else {
                        self.text = error?.localizedDescription ?? "error"
                    }
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(viewModel: ContentView.ViewModel())
	}
}
