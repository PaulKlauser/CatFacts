import SwiftUI
import shared

struct ContentView: View {
    let viewModel = SharedViewModel()
    
    var body: some View {
        Observing(viewModel.uiState) { state in
            VStack {
                switch onEnum(of: state) {
                case .initial:
                    Text("Tap Button")
                case .loading:
                    Text("Loading...")
                case .success(let success):
                    Text(success.catFact)
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
