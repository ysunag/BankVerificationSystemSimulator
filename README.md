# Secure Bank Verification System Simulator

The program, SecureBankVerificationSimulator, randomly creates the requested number of unique clients(Every bank client has: a unique ID number, a (private key, public key) RSA pair, a deposit limit and a withdrawal limit) and the requested number of unique pairs (message, digital signature), taking into account parameter the percentage of incorrect message parameter. For each of the unique (message, digital signature) pairs, it then simulates the verification process, and writes the simulation results into the provided output file.
