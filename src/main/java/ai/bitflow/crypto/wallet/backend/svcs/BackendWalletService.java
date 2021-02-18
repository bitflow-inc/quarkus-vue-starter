package ai.bitflow.crypto.wallet.backend.svcs;

import ai.bitflow.crypto.wallet.backend.repos.ContactRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BackendWalletService {

    @Inject
    ContactRepo cRepo;

}
