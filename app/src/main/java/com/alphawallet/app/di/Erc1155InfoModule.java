package com.alphawallet.app.di;

import com.alphawallet.app.interact.FetchTransactionsInteract;
import com.alphawallet.app.repository.TokenRepositoryType;
import com.alphawallet.app.repository.TransactionRepositoryType;
import com.alphawallet.app.router.MyAddressRouter;
import com.alphawallet.app.service.AssetDefinitionService;
import com.alphawallet.app.service.TokensService;
import com.alphawallet.app.viewmodel.Erc1155InfoViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class Erc1155InfoModule {
    @Provides
    Erc1155InfoViewModelFactory provideErc1155InfoViewModelFactory(FetchTransactionsInteract fetchTransactionsInteract,
                                                                   AssetDefinitionService assetDefinitionService,
                                                                   TokensService tokensService)
    {
        return new Erc1155InfoViewModelFactory(
                fetchTransactionsInteract,
                assetDefinitionService,
                tokensService);
    }

    @Provides
    MyAddressRouter provideMyAddressRouter()
    {
        return new MyAddressRouter();
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepositoryType,
                                                               TokenRepositoryType tokenRepositoryType)
    {
        return new FetchTransactionsInteract(transactionRepositoryType, tokenRepositoryType);
    }
}
