import os
import chromadb
from services.embedding_service import init_embedding_model, get_embedding_model

DOCUMENTS = [
    "ESG reporting requires tracking scope 1, scope 2, and scope 3 carbon emissions.",
    "Good governance includes a diverse board of directors and transparent executive compensation.",
    "Social responsibility involves fair labor practices, employee well-being, and community engagement.",
    "Environmental sustainability focuses on resource efficiency, waste reduction, and renewable energy.",
    "The GHG Protocol is the most widely used international accounting tool to quantify greenhouse gas emissions.",
    "Materiality assessments help identify the ESG issues that are most critical to the business and its stakeholders.",
    "A comprehensive waste management policy includes reduction, recycling, and responsible disposal of hazardous materials.",
    "Diversity, Equity, and Inclusion (DEI) initiatives are critical components of the social pillar in ESG.",
    "Data privacy and cybersecurity are increasingly recognized as critical governance and social issues.",
    "Transition risks refer to the financial risks associated with the shift toward a low-carbon economy."
]

def seed_chromadb():
    print("Initializing embedding model...")
    init_embedding_model()
    model = get_embedding_model()

    if not model:
        print("❌ Embedding model failed to load. Cannot seed ChromaDB.")
        return

    print("Initializing ChromaDB Persistent Client...")
    BASE_DIR = os.path.dirname(os.path.abspath(__file__))
    chroma_path = os.path.join(BASE_DIR, "chroma_data")
    client = chromadb.PersistentClient(path=chroma_path)
    
    collection = client.get_or_create_collection(name="esg_knowledge")
    
    print(f"Generating embeddings and seeding {len(DOCUMENTS)} documents into ChromaDB...")
    
    embeddings = model.encode(DOCUMENTS).tolist()
    ids = [f"esg_knowledge_{i+1}" for i in range(len(DOCUMENTS))]
    
    collection.add(
        documents=DOCUMENTS,
        embeddings=embeddings,
        ids=ids
    )
    
    print("✅ ChromaDB seeding successfully completed!")

if __name__ == "__main__":
    seed_chromadb()
